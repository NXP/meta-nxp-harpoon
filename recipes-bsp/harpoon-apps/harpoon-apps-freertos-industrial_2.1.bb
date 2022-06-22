# Copyright (C) 2022 NXP

require harpoon-apps-freertos.inc

SUMMARY = "Harpoon Application - Industrial (FreeRTOS)"

GENAVB_BRANCH="5_0"

SRC_URI += "git://github.com/NXP/GenAVB_TSN.git;protocol=https;branch=${GENAVB_BRANCH};destsuffix=git/gen_avb_sdk;name=gen-avb-sdk"
SRCREV_FORMAT:append = "_gen-avb-sdk"
SRCREV_gen-avb-sdk = "0fc0f1c854a1a7ad3199a053f607107f2b2a511f"

HARPOON_APPS_APP = "industrial"
HARPOON_APPS_APP_BIN = "industrial.bin"
