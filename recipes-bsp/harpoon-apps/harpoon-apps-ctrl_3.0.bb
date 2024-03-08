# Copyright (C) 2021-2022 NXP

require harpoon-apps-uri.inc

SUMMARY = "Harpoon Application - Linux Control"
SECTION = "bsp"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f"

S = "${WORKDIR}/git/harpoon-apps"

SRC_URI = "${SRC_HARPOON_APPS}"
SRCREV = "${SRCREV_harpoon-apps}"

inherit cmake systemd

SYSTEMD_SERVICE:${PN} = "harpoon.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

HARPOON_DATADIR ?= "${datadir}/harpoon"
SCRIPTS_DIR ?= "${HARPOON_DATADIR}/scripts"

HARPOON_APPS_SCRIPT_DIR = "${S}/scripts"
HARPOON_APPS_CODE_DIR = "${S}/ctrl"
HARPOON_APPS_APP_BIN = "harpoon_ctrl"

SOC:mx8mm-nxp-bsp = "imx8mm"
SOC:mx8mn-nxp-bsp = "imx8mn"
SOC:mx8mp-nxp-bsp = "imx8mp"
SOC:mx93-nxp-bsp = "imx93"

INMATE_ENTRY_ADDRESS:mx8mm-nxp-bsp = "0x93c00000"
INMATE_ENTRY_ADDRESS:mx8mn-nxp-bsp = "0x93c00000"
INMATE_ENTRY_ADDRESS:mx8mp-nxp-bsp = "0xc0000000"
INMATE_ENTRY_ADDRESS:mx93-nxp-bsp = "0xd0000000"

do_install() {
	# Install Linux control application binary
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/build/${HARPOON_APPS_APP_BIN} ${D}${bindir}

	# Install Jailhouse and Harpoon Configure scripts
	install -d ${D}${SCRIPTS_DIR}
	install -m 0755 ${HARPOON_APPS_SCRIPT_DIR}/jh_harpoon.sh ${D}${SCRIPTS_DIR}
	install -m 0755 ${HARPOON_APPS_SCRIPT_DIR}/harpoon_configure.sh ${D}${SCRIPTS_DIR}

	# Instantiate Harpoon default configuration file
	sed -e "s|%TEMPLATE_SOC%|${SOC}|" \
	    -e "s|%TEMPLATE_ENTRY%|${INMATE_ENTRY_ADDRESS}|" \
	    ${HARPOON_APPS_SCRIPT_DIR}/harpoon.conf.template > \
	    ${HARPOON_APPS_SCRIPT_DIR}/harpoon.conf

	# Install Harpoon default configuration file and its generator
	install -d ${D}${sysconfdir}/harpoon
	install -m 0644 ${HARPOON_APPS_SCRIPT_DIR}/harpoon.conf ${D}/${sysconfdir}/harpoon/
	install -m 0755 ${HARPOON_APPS_SCRIPT_DIR}/harpoon_set_configuration.sh ${D}${bindir}

	# Install systemd service
	install -d ${D}/${systemd_unitdir}/system
	install -m 0644 ${HARPOON_APPS_SCRIPT_DIR}/systemd/harpoon.service ${D}/${systemd_unitdir}/system
}

DEPENDS = ""
RDEPENDS:${PN} += "bash"

OECMAKE_SOURCEPATH = "${HARPOON_APPS_CODE_DIR}"
OECMAKE_GENERATOR = "Unix Makefiles"

COMPATIBLE_MACHINE = "(imx8mp-lpddr4-evk|imx8mm-lpddr4-evk|imx8mn-lpddr4-evk|imx93evk)"
FILES:${PN} += "${HARPOON_DATADIR}"
FILES:${PN} += "${bindir}"
FILES:${PN} += "${sysconfdir}"
FILES:${PN} += "${systemd_unitdir}/system/harpoon.service"
PACKAGE_ARCH = "${MACHINE_ARCH}"
