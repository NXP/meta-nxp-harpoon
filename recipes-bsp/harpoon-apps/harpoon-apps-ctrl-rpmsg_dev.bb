# Copyright 2022 NXP

require harpoon-apps-uri.inc

SUMMARY = "Harpoon Application - Linux Control (RPMSG based)"
SECTION = "bsp"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSES/COPYING-BSD-3;md5=b1a3c7f4e16fc8aa105097dd385e900f"

S = "${WORKDIR}/git/harpoon-apps"

SRC_URI = "${SRC_HARPOON_APPS}"
SRCREV = "${SRCREV_harpoon-apps}"

inherit cmake

HARPOON_DATADIR ?= "${datadir}/harpoon"

HARPOON_APPS_CODE_DIR = "${S}/ctrl"
HARPOON_APPS_APP_BIN = "harpoon_ctrl_rpmsg"

do_install() {
	# Install Linux control application binary
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/build/${HARPOON_APPS_APP_BIN} ${D}${bindir}
}

DEPENDS = ""
RDEPENDS:${PN} += "bash"

OECMAKE_SOURCEPATH = "${HARPOON_APPS_CODE_DIR}"
OECMAKE_GENERATOR = "Unix Makefiles"
EXTRA_OECMAKE += "-DMBOX_TRANSPORT_RPMSG=on"

COMPATIBLE_MACHINE = "(imx8mm-lpddr4-evk)"
FILES:${PN} += "${HARPOON_DATADIR}"
FILES:${PN} += "${bindir}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
