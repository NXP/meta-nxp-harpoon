# Copyright (C) 2023 NXP

LICENSE = "BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = " \
    file://rtos-abstraction-layer/licenses/BSD-3-Clause;md5=48edf1a6294aa09a7061911a72eb3ab5 \
    file://rtos-abstraction-layer/licenses/MIT;md5=cbc289d25c879758a678f6bcca0b2fdb"

RTOS_ABSTRACTION_LAYER_BRANCH="0_1"
SRC_RTOS_ABSTRACTION_LAYER = "git://github.com/NXP/rtos-abstraction-layer.git;protocol=https;branch=${RTOS_ABSTRACTION_LAYER_BRANCH};destsuffix=git/rtos-abstraction-layer;name=rtos-abstraction-layer"

SRCREV_rtos-abstraction-layer = "804e444b704b005a459304fdcd38b796676c4442"
SRCREV_FORMAT:append = "_rtos-abstraction-layer"
