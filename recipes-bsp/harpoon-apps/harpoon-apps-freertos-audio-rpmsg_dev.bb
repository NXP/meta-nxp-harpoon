# Copyright 2022 NXP

require harpoon-apps-freertos.inc
require gen-avb-sdk-uri.inc
require rpmsg-lite-uri.inc

SUMMARY = "Harpoon Application - Audio (FreeRTOS)"

# Current only available on imx8mm-lpddr-evk
COMPATIBLE_MACHINE:remove = "imx8mp-lpddr4-evk imx8mn-lpddr4-evk"

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

EXTRA_OECMAKE += "-DMBOX_TRANSPORT_RPMSG=on"

HARPOON_APPS_APP = "audio"
HARPOON_APPS_APP_BIN = "audio_rpmsg.bin"
