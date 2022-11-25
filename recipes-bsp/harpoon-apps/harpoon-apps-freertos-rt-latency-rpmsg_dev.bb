# Copyright 2022 NXP

require harpoon-apps-freertos.inc
require rpmsg-lite-uri.inc

SUMMARY = "Harpoon Application - RT Latency (FreeRTOS)"

# Current only available on imx8mm-lpddr-evk
COMPATIBLE_MACHINE:remove = "imx8mp-lpddr4-evk imx8mn-lpddr4-evk"

EXTRA_OECMAKE += "-DMBOX_TRANSPORT_RPMSG=on"

HARPOON_APPS_APP = "rt_latency"
HARPOON_APPS_APP_BIN = "rt_latency_rpmsg.bin"
