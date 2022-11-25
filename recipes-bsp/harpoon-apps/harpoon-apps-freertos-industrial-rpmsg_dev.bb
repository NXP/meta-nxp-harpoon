# Copyright 2022 NXP

require harpoon-apps-freertos.inc
require gen-avb-sdk-uri.inc
require rpmsg-lite-uri.inc

SUMMARY = "Harpoon Application - Industrial (FreeRTOS)"

# Current only available on imx8mm-lpddr-evk
COMPATIBLE_MACHINE:remove = "imx8mp-lpddr4-evk imx8mn-lpddr4-evk"

SRC_URI += "${SRC_GEN_AVB_SDK}"
SRCREV_FORMAT:append = "_gen-avb-sdk"

EXTRA_OECMAKE += "-DMBOX_TRANSPORT_RPMSG=on"

HARPOON_APPS_APP = "industrial"
HARPOON_APPS_APP_BIN = "industrial_rpmsg.bin"
