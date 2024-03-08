# Copyright 2023-2024 NXP

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://rtos-abstraction-layer/LICENSE.txt;md5=776f3a33e288dbcf623ebd2123088a45"

RTOS_ABSTRACTION_LAYER_BRANCH="1_0"
SRC_RTOS_ABSTRACTION_LAYER = "git://github.com/NXP/rtos-abstraction-layer.git;protocol=https;branch=${RTOS_ABSTRACTION_LAYER_BRANCH};destsuffix=git/rtos-abstraction-layer;name=rtos-abstraction-layer"

SRCREV_rtos-abstraction-layer = "c6952d8688c72c1b0e61c158f77116f202cc95be"
SRCREV_FORMAT:append = "_rtos-abstraction-layer"
