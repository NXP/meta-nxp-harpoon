# Copyright 2022 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "NXP Harpoon package group"
DESCRIPTION = "Contains the packages needed by Harpoon."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "${PN}"

harpoon-pkgs ?= ""
harpoon-pkgs_imx8mm-lpddr4-evk = "harpoon-apps-ctrl harpoon-apps-audio harpoon-apps-rt-latency"
harpoon-pkgs_imx8mn-lpddr4-evk = "harpoon-apps-ctrl harpoon-apps-audio harpoon-apps-rt-latency"
harpoon-pkgs_imx8mp-lpddr4-evk = "harpoon-apps-ctrl harpoon-apps-audio harpoon-apps-rt-latency"

RDEPENDS_${PN} = " \
    ${harpoon-pkgs} \
"
