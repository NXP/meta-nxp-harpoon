# Copyright (C) 2022-2023 NXP

require harpoon-apps-common.inc
require harpoon-apps-uri.inc

inherit python3native

LICENSE = "BSD-3-Clause & Apache-2.0 & Proprietary"
LIC_FILES_CHKSUM = " \
    file://zephyr/LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc \
    file://modules/hal/nxp/mcux/mcux-sdk/LA_OPT_NXP_Software_License.txt;md5=05d4eaca7b4661792db56269cb11938d \
    file://harpoon-apps/LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f"

SRC_URI = "\
    ${SRC_HARPOON_APPS} \
    git://github.com/nxp-zephyr/zephyr.git;protocol=https;nobranch=1;destsuffix=git/zephyr;name=zephyr \
    git://github.com/nxp-zephyr/hal_nxp.git;protocol=https;nobranch=1;destsuffix=git/modules/hal/nxp;name=hal-nxp \
"

SRCREV_FORMAT = "harpoon-apps_zephyr_hal-nxp"

SRCREV_zephyr = "e0d0f16c74ca97d9e4c25b256c5c91f29233b76f"
SRCREV_hal-nxp = "996f5fd03b140cd5eef2a3685127c2984f06d403"

INMATES_DIR ?= "${HARPOON_DATADIR}/inmates/zephyr"

HARPOON_APPS_CODE_DIR = "${S}/harpoon-apps/${HARPOON_APPS_APP}/zephyr"

do_install() {
	install -d ${D}${INMATES_DIR}
	install -m 0644 ${B}/zephyr/${HARPOON_APPS_APP_BIN} ${D}${INMATES_DIR}
}

do_configure:prepend () {
	export ARMGCC_DIR="${TMPDIR}/sysroots-components/${BUILD_ARCH}/${ARM_TC}-native/usr/bin/${ARM_TC}-native-${ARM_PV}/"
	export ZEPHYR_TOOLCHAIN_VARIANT=cross-compile
	export CROSS_COMPILE="${ARMGCC_DIR}"bin/aarch64-none-elf-
	export Zephyr_DIR="${S}/zephyr"
	cp -f ${S}/modules/hal/nxp/mcux/mcux-sdk/tools/cmake_toolchain_files/armgcc_aarch64.cmake ${WORKDIR}/toolchain.cmake
}

SECURITY_STACK_PROTECTOR = ""
OECMAKE_SOURCEPATH = "${HARPOON_APPS_CODE_DIR}"
OECMAKE_GENERATOR = "Ninja"
ZEPHYR_MODULES = "'${S}/modules/hal/cmsis;${S}/modules/hal/nxp/'"
EXTRA_OECMAKE += "-DBOARD=${BOARD} -DZEPHYR_MODULES=${ZEPHYR_MODULES} ${EXTRA_HARPOON_FLAGS}"

DEPENDS += "python3-packaging-native"
DEPENDS += "python3-pyelftools-native"
DEPENDS += "python3-pykwalify-native"
DEPENDS += "python3-pyyaml-native"
