# Copyright (C) 2021-2022 NXP

SECTION = "bsp"

inherit cmake

S = "${WORKDIR}/git"

HARPOON_DATADIR ?= "${datadir}/harpoon"

ARM_TC = "gcc-arm-aa64-elf"
ARM_PV = "10.3"
DEPENDS += "${ARM_TC}-native (= ${ARM_PV})"
RDEPENDS:${PN}:real-time-edge += "real-time-edge-jailhouse"

COMPATIBLE_MACHINE = "(imx8mp-lpddr4-evk|imx8mm-lpddr4-evk|imx8mn-lpddr4-evk)"
FILES:${PN} += "${HARPOON_DATADIR}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
