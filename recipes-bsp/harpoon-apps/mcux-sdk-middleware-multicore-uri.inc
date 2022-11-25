# Copyright 2022 NXP

MULTICORE_BRANCH = "feature/heterogeneous_multicore"

SRC_URI += "\
    git://github.com/NXPmicro/mcux-sdk-middleware-multicore.git;protocol=https;branch=${MULTICORE_BRANCH};destsuffix=git/middleware/multicore;name=mcux-sdk-middleware-multicore \
"

SRCREV_FORMAT:append = "_mcux-sdk-middleware-multicore"
SRCREV_mcux-sdk-middleware-multicore = "070e9e645bee2cfa3257200b70c2c1ef6cc09440"
