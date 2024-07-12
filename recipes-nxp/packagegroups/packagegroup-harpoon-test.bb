# Copyright 2022 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "NXP Harpoon Test package group"
DESCRIPTION = "Contains the packages needed by Harpoon test framework."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    python3 \
    python3-click \
    python3-pytest \
    python3-pytest-html \
"
