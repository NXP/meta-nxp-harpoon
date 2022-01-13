# Copyright (C) 2021-2022 NXP

SECTION = "bsp"

LICENSE = "BSD-3-Clause & MIT & Proprietary"
#LIC_FILES_CHKSUM = "file://harpoon-apps/LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f
LIC_FILES_CHKSUM = " \
    file://mcux-sdk/LA_OPT_NXP_Software_License.txt;md5=6c8be969fb3477739a057036fb2e9ee8 \
    file://FreeRTOS-Kernel/LICENSE.md;md5=7ae2be7fb1637141840314b51970a9f7"

S = "${WORKDIR}/git"

SRC_URI = "\
    git://github.com/NXPmicro/harpoon-apps.git;protocol=https;branch=${SRCBRANCH_harpoon-apps};destsuffix=git/harpoon-apps;name=harpoon-apps \
    git://github.com/NXPmicro/mcux-sdk.git;protocol=https;branch=${SRCBRANCH_mcux-sdk};destsuffix=git/mcux-sdk;name=mcux-sdk \
    git://github.com/NXPmicro/FreeRTOS-Kernel.git;protocol=https;branch=${SRCBRANCH_FreeRTOS-Kernel};destsuffix=git/FreeRTOS-Kernel;name=FreeRTOS-Kernel \
"

SRCREV_FORMAT = "harpoon-apps_mcux-sdk_FreeRTOS-Kernel"
SRCREV_harpoon-apps = "b5c81fa4f0813a2b8973198c027b313dde02c07e"
SRCREV_mcux-sdk = "46d44c68e6cb7f97a68e6a1f75aaf4337dba90b5"
SRCREV_FreeRTOS-Kernel = "51e25b23a8738b8326cd751ef3063e7ec2544633"
SRCBRANCH_harpoon-apps = "main"
SRCBRANCH_mcux-sdk = "feature/aarch64_support"
SRCBRANCH_FreeRTOS-Kernel = "feature/aarch64_support"

inherit cmake

BOARD_imx8mp-lpddr4-evk = "evkmimx8mp"
BOARD_imx8mm-lpddr4-evk = "evkmimx8mm"
BOARD_imx8mn-lpddr4-evk = "evkmimx8mn"

HARPOON_DATADIR ?= "${datadir}/harpoon"
INMATES_DIR ?= "${HARPOON_DATADIR}/inmates"

BUILD_TYPE = "ddr_release"

HARPOON_APPS_CODE_DIR = "${S}/harpoon-apps/${HARPOON_APPS_APP}/freertos/boards/${BOARD}/armgcc_aarch64"

do_install() {
	install -d ${D}${INMATES_DIR}
	install -m 0644 ${HARPOON_APPS_CODE_DIR}/${BUILD_TYPE}/${HARPOON_APPS_APP_BIN} ${D}${INMATES_DIR}
}

do_configure_prepend () {
	export ARMGCC_DIR="${TMPDIR}/sysroots-components/${BUILD_ARCH}/${ARM_TC}-native/usr/bin/${ARM_TC}-native-${ARM_PV}/"

	if [ -d "CMakeFiles" ];then rm -rf CMakeFiles; fi
	if [ -f "Makefile" ];then rm -f Makefile; fi
	if [ -f "cmake_install.cmake" ];then rm -f cmake_install.cmake; fi
	if [ -f "CMakeCache.txt" ];then rm -f CMakeCache.txt; fi
	cp -f ${S}/mcux-sdk/tools/cmake_toolchain_files/armgcc_aarch64.cmake ${WORKDIR}/toolchain.cmake
}

ARM_TC = "gcc-arm-aa64-elf"
ARM_PV = "10.2"
DEPENDS += "${ARM_TC}-native (= ${ARM_PV})"
RDEPENDS_${PN}_real-time-edge += "real-time-edge-jailhouse"

SECURITY_STACK_PROTECTOR = ""
OECMAKE_SOURCEPATH = "${HARPOON_APPS_CODE_DIR}"
OECMAKE_GENERATOR = "Unix Makefiles"
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=${BUILD_TYPE} ${EXTRA_HARPOON_FLAGS}"

COMPATIBLE_MACHINE = "(imx8mp-lpddr4-evk|imx8mm-lpddr4-evk|imx8mn-lpddr4-evk)"
FILES_${PN} += "${HARPOON_DATADIR}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
