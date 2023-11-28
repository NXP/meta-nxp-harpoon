# Copyright (C) 2021-2023 NXP

require harpoon-apps-common.inc
require harpoon-apps-uri.inc

LICENSE = "BSD-3-Clause & Apache-2.0 & MIT & Proprietary"
LIC_FILES_CHKSUM = " \
    file://mcux-sdk/LA_OPT_NXP_Software_License.txt;md5=71d85499ae575285003624d1069c714b \
    file://mcux-sdk/CMSIS/LICENSE.txt;md5=e3fc50a88d0a364313df4b21ef20c29e \
    file://FreeRTOS-Kernel/LICENSE.md;md5=7ae2be7fb1637141840314b51970a9f7 \
    file://harpoon-apps/LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f"

SRC_URI = "\
    ${SRC_HARPOON_APPS} \
    git://github.com/nxp-mcuxpresso/mcux-sdk.git;protocol=https;nobranch=1;destsuffix=git/mcux-sdk;name=mcux-sdk \
    git://github.com/nxp-mcuxpresso/CMSIS_5.git;protocol=https;nobranch=1;destsuffix=git/mcux-sdk/CMSIS;name=CMSIS \
    git://github.com/nxp-mcuxpresso/FreeRTOS-Kernel.git;protocol=https;nobranch=1;destsuffix=git/FreeRTOS-Kernel;name=FreeRTOS-Kernel \
"

SRCREV_FORMAT = "harpoon-apps_mcux-sdk_CMSIS_FreeRTOS-Kernel"

SRCREV_mcux-sdk = "d2c5fe71520d2933600e988cda6d8af029c516e7"
SRCREV_CMSIS = "66a180f8b67fb3fdd11271bb31f5abec42fa2f62"
SRCREV_FreeRTOS-Kernel = "d2ca5ca56c79edac658773aa16cf0fd63e566a04"

BOARD:imx8mp-lpddr4-evk = "evkmimx8mp"
BOARD:imx8mm-lpddr4-evk = "evkmimx8mm"
BOARD:imx8mn-lpddr4-evk = "evkmimx8mn"
BOARD:imx93evk = "mcimx93evk"

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
