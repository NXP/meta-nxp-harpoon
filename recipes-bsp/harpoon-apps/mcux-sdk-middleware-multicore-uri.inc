# Copyright 2022 NXP

MULTICORE_BRANCH = "feature/heterogeneous_multicore"

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/mcux-sdk-middleware-multicore.git;protocol=https;branch=${MULTICORE_BRANCH};destsuffix=git/middleware/multicore;name=mcux-sdk-middleware-multicore \
"

SRCREV_FORMAT:append = "_mcux-sdk-middleware-multicore"
SRCREV_mcux-sdk-middleware-multicore = "2d89233a3be1f9533bd948f33dd6d0275d72cedd"
