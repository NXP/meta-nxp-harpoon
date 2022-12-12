# Copyright (C) 2022 NXP

require harpoon-apps-freertos.inc
require gen-avb-sdk-uri.inc

SUMMARY = "Harpoon Application - Industrial (FreeRTOS)"

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

HARPOON_APPS_APP = "industrial"
HARPOON_APPS_APP_BIN = "industrial.bin"
