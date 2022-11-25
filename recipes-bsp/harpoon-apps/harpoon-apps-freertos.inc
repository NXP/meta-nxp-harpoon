# Copyright (C) 2021-2022 NXP

require harpoon-apps-common.inc
require harpoon-apps-uri.inc

LICENSE = "BSD-3-Clause & MIT & Proprietary"
LIC_FILES_CHKSUM = " \
    file://mcux-sdk/LA_OPT_NXP_Software_License.txt;md5=e435b49b43aa6f17047226cf6158600b \
    file://FreeRTOS-Kernel/LICENSE.md;md5=7ae2be7fb1637141840314b51970a9f7 \
    file://harpoon-apps/LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f"

SRC_URI = "\
    ${SRC_HARPOON_APPS} \
    git://github.com/NXPmicro/mcux-sdk.git;protocol=https;branch=${SRCBRANCH_mcux-sdk};destsuffix=git/mcux-sdk;name=mcux-sdk \
    git://github.com/NXPmicro/FreeRTOS-Kernel.git;protocol=https;branch=${SRCBRANCH_FreeRTOS-Kernel};destsuffix=git/FreeRTOS-Kernel;name=FreeRTOS-Kernel \
"

SRCREV_FORMAT = "harpoon-apps_mcux-sdk_FreeRTOS-Kernel"

SRCREV_mcux-sdk = "cb3b07a151bb27d3477f58bc5d1df3e259e4018a"
SRCREV_FreeRTOS-Kernel = "8df2481c594a05d69f15e9052471586184fa88cc"
SRCBRANCH_mcux-sdk = "feature/aarch64_support"
SRCBRANCH_FreeRTOS-Kernel = "feature/aarch64_support"

BOARD:imx8mp-lpddr4-evk = "evkmimx8mp"
BOARD:imx8mm-lpddr4-evk = "evkmimx8mm"
BOARD:imx8mn-lpddr4-evk = "evkmimx8mn"

INMATES_DIR ?= "${HARPOON_DATADIR}/inmates/freertos"

BUILD_TYPE = "ddr_release"

HARPOON_APPS_CODE_DIR = "${S}/harpoon-apps/${HARPOON_APPS_APP}/freertos/boards/${BOARD}/armgcc_aarch64"

do_install() {
	install -d ${D}${INMATES_DIR}
	install -m 0644 ${HARPOON_APPS_CODE_DIR}/${BUILD_TYPE}/${HARPOON_APPS_APP_BIN} ${D}${INMATES_DIR}
}

do_configure:prepend () {
	export ARMGCC_DIR="${TMPDIR}/sysroots-components/${BUILD_ARCH}/${ARM_TC}-native/usr/bin/${ARM_TC}-native-${ARM_PV}/"

	if [ -d "CMakeFiles" ];then rm -rf CMakeFiles; fi
	if [ -f "Makefile" ];then rm -f Makefile; fi
	if [ -f "cmake_install.cmake" ];then rm -f cmake_install.cmake; fi
	if [ -f "CMakeCache.txt" ];then rm -f CMakeCache.txt; fi
	cp -f ${S}/mcux-sdk/tools/cmake_toolchain_files/armgcc_aarch64.cmake ${WORKDIR}/toolchain.cmake
}

SECURITY_STACK_PROTECTOR = ""
OECMAKE_SOURCEPATH = "${HARPOON_APPS_CODE_DIR}"
OECMAKE_GENERATOR = "Unix Makefiles"
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=${BUILD_TYPE} ${EXTRA_HARPOON_FLAGS}"
