# Copyright 2023 NXP

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://heterogeneous-multicore/LICENSE.txt;md5=b1a3c7f4e16fc8aa105097dd385e900f"

VIRTIO_BRANCH="master"

SRC_HETEROGENEOUS_MULTICORE = "git://git@bitbucket.sw.nxp.com/dnind/heterogeneous-multicore.git;protocol=ssh;branch=${VIRTIO_BRANCH};destsuffix=git/heterogeneous-multicore;name=heterogeneous-multicore"

SRC_URI += "${SRC_HETEROGENEOUS_MULTICORE}"
SRCREV_FORMAT:append = "_heterogeneous-multicore"

SRCREV_heterogeneous-multicore = "${AUTOREV}"
