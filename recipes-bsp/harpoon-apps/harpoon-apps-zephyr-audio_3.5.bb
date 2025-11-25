# Copyright 2022-2023, 2025 NXP

require harpoon-apps-zephyr.inc
require harpoon-apps-zephyr-boards-singlecore.inc
require gen-avb-sdk-uri.inc
require rpmsg-lite-uri.inc

SUMMARY = "Harpoon Application - Audio (Zephyr)"

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

HARPOON_APPS_APP = "audio"
HARPOON_APPS_APP_BIN = "audio.bin"
