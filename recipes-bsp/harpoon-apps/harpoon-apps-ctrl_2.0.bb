# Copyright (C) 2021 NXP

SUMMARY = "Harpoon Application - Linux Control"
SECTION = "bsp"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/NXPmicro/harpoon-apps.git;protocol=https;branch=main"
SRCREV = "b5c81fa4f0813a2b8973198c027b313dde02c07e"

inherit cmake

BOARD_imx8mp-lpddr4-evk = "evkmimx8mp"
BOARD_imx8mm-lpddr4-evk = "evkmimx8mm"
BOARD_imx8mn-lpddr4-evk = "evkmimx8mn"

HARPOON_DATADIR ?= "${datadir}/harpoon"
INMATES_DIR ?= "${HARPOON_DATADIR}/inmates"
SCRIPTS_DIR ?= "${HARPOON_DATADIR}/scripts"

BUILD_TYPE = "ddr_release"

HARPOON_APPS_SCRIPT_DIR = "${S}/scripts"
HARPOON_APPS_CODE_DIR = "${S}/ctrl"
HARPOON_APPS_APP_BIN = "harpoon_ctrl"

do_install() {
	install -d ${D}${HARPOON_DATADIR}
	install -d ${D}${SCRIPTS_DIR}

	# Install Linux control application binary
	install -m 0755 ${WORKDIR}/build/${HARPOON_APPS_APP_BIN} ${D}${HARPOON_DATADIR}

	# Instantiate jstart script for Industrial app
	sed -e "s|%TEMPLATE_ROOT_CELL%|${JH_ROOT_CELL}|" \
	    -e "s|%TEMPLATE_INMATE_CELL%|${JH_FREERTOS_CELL}|" \
	    -e "s|%TEMPLATE_INMATE_NAME%|freertos|" \
	    -e "s|%TEMPLATE_BINS_PATH%|${INMATES_DIR}|" \
	    -e "s|%TEMPLATE_INMATE_BIN%|rt_latency.bin|" \
	    ${HARPOON_APPS_SCRIPT_DIR}/jstart_inmate.sh.template > \
	    ${HARPOON_APPS_SCRIPT_DIR}/jstart_freertos.sh

	# Instantiate jstart script for IoT/Audio app
	sed -e "s|%TEMPLATE_ROOT_CELL%|${JH_ROOT_CELL}|" \
	    -e "s|%TEMPLATE_INMATE_CELL%|${JH_FREERTOS_AUDIO_CELL}|" \
	    -e "s|%TEMPLATE_INMATE_NAME%|freertos|" \
	    -e "s|%TEMPLATE_BINS_PATH%|${INMATES_DIR}|" \
	    -e "s|%TEMPLATE_INMATE_BIN%|audio.bin|" \
	    ${HARPOON_APPS_SCRIPT_DIR}/jstart_inmate.sh.template > \
	    ${HARPOON_APPS_SCRIPT_DIR}/jstart_freertos_audio.sh

	# Instantiate jkill script for both apps
	sed -e "s|%TEMPLATE_INMATE_NAME%|freertos|" \
	    ${HARPOON_APPS_SCRIPT_DIR}/jkill_inmate.sh.template > \
	    ${HARPOON_APPS_SCRIPT_DIR}/jkill_freertos.sh

	# Install Jailhouse scripts
	install -m 0755 ${HARPOON_APPS_SCRIPT_DIR}/j*.sh ${D}${SCRIPTS_DIR}
}

DEPENDS = ""
RDEPENDS_${PN} += "bash"

OECMAKE_SOURCEPATH = "${HARPOON_APPS_CODE_DIR}"
OECMAKE_GENERATOR = "Unix Makefiles"

COMPATIBLE_MACHINE = "(imx8mp-lpddr4-evk|imx8mm-lpddr4-evk|imx8mn-lpddr4-evk)"
FILES_${PN} += "${HARPOON_DATADIR}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
