# Copyright 2022-2023, 2025 NXP

require harpoon-apps-zephyr.inc
require harpoon-apps-zephyr-boards-singlecore.inc
require gen-avb-sdk-uri.inc
require rpmsg-lite-uri.inc

SUMMARY = "Harpoon Application - Industrial (Zephyr)"

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

HARPOON_APPS_APP = "industrial"
HARPOON_APPS_APP_BIN = "industrial.bin"

# Define DTS_ROOT to fetch extra Zephyr dts binding
EXTRA_HARPOON_FLAGS:append:imx95-15x15-lpddr4x-evk = " -DDTS_ROOT=boards/imx95lp4xevk15"
EXTRA_HARPOON_FLAGS:append:imx95-19x19-lpddr5-evk = " -DDTS_ROOT=boards/imx95lpd5evk19"
