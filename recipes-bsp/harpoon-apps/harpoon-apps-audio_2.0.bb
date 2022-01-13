# Copyright (C) 2021 NXP

require harpoon-apps.inc

SUMMARY = "Harpoon Application - Audio"

HARPOON_APPS_APP = "audio"
HARPOON_APPS_APP_BIN = "audio.bin"

EXTRA_HARPOON_FLAGS = "-DCODEC_DEVICE=hifiberry"
