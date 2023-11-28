# Copyright (C) 2022-2023 NXP

require harpoon-apps-zephyr.inc
require harpoon-apps-zephyr-boards-singlecore.inc
require gen-avb-sdk-uri.inc
require rtos-abstraction-layer-uri.inc
require rpmsg-lite-uri.inc

SUMMARY = "Harpoon Application - Industrial (Zephyr)"

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

SRC_URI += "${SRC_RTOS_ABSTRACTION_LAYER}"
SRCREV_FORMAT:append = "_rtos-abstraction-layer"

HARPOON_APPS_APP = "industrial"
HARPOON_APPS_APP_BIN = "industrial.bin"
