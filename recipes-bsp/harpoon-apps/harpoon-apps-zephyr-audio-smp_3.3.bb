# Copyright 2022-2023 NXP

require harpoon-apps-zephyr.inc
require harpoon-apps-zephyr-boards-smp.inc
require rpmsg-lite-uri.inc
require gen-avb-sdk-uri.inc

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

SUMMARY = "Harpoon Application - Audio SMP (Zephyr)"

HARPOON_APPS_APP = "audio"
HARPOON_APPS_APP_BIN = "audio_smp.bin"
