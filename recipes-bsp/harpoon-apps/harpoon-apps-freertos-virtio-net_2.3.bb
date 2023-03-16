# Copyright 2023 NXP

require harpoon-apps-freertos.inc
require heterogeneous-multicore.inc

SUMMARY = "Harpoon Application - Virtio NET (FreeRTOS)"

SRC_URI += "${SRC_HETEROGENEOUS_MULTICORE}"
SRCREV_FORMAT:append = "_heterogeneous-multicore"

HARPOON_APPS_APP = "virtio_net"
HARPOON_APPS_APP_BIN = "virtio_net.bin"
