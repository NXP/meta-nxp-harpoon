# Copyright 2022 NXP

MULTICORE_BRANCH = "feature/heterogeneous_multicore"

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/mcux-sdk-middleware-multicore.git;protocol=https;branch=${MULTICORE_BRANCH};destsuffix=git/middleware/multicore;name=mcux-sdk-middleware-multicore \
"

SRCREV_FORMAT:append = "_mcux-sdk-middleware-multicore"
SRCREV_mcux-sdk-middleware-multicore = "e914909af2bf44fd651e3383ba0cd8cf5f0bda66"
