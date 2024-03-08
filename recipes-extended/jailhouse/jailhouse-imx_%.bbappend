FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-configs-arm64-imx8mn-fix-typo-in-name.patch"
SRC_URI += "file://0002-arm-gic-v3-Inject-IRQ-priority-for-SGI.patch"
SRC_URI += "file://0003-arm-common-irqchip-Fix-the-mask-according-to-access-.patch"
SRC_URI += "file://0004-configs-Introduce-helper-files-to-create-inmate-cell.patch"
SRC_URI += "file://0005-configs-Guest-virtual-console.patch"
SRC_URI += "file://0006-configs-arm64-imx8mp-add-freertos-basic-and-audio-ce.patch"
SRC_URI += "file://0007-configs-arm64-imx8mp-add-harpoon-zephyr-basic-cell.patch"
SRC_URI += "file://0008-configs-arm64-imx8mm-add-harpoon-freertos-basic-and-.patch"
SRC_URI += "file://0009-configs-arm64-imx8mn-add-harpoon-basic-and-audio-cel.patch"
SRC_URI += "file://0010-configs-arm64-imx8m-m-n-p-add-harpoon-freertos-indus.patch"
SRC_URI += "file://0011-configs-arm64-imx8m-m-n-p-Add-all-SAI-instances-to-h.patch"
SRC_URI += "file://0012-configs-arm64-imx8m-m-n-Change-to-1-1-IPA-PA-mapping.patch"
SRC_URI += "file://0013-configs-arm64-imx8m-m-n-add-harpoon-zephyr-basic-cel.patch"
SRC_URI += "file://0014-configs-arm64-imx8m-m-n-p-add-harpoon-zephyr-industr.patch"
SRC_URI += "file://0015-configs-arm64-imx8m-m-n-p-add-harpoon-audio-zephyr-c.patch"
SRC_URI += "file://0016-configs-arm64-imx8m-rework-imx8m-harpoon-cell-constr.patch"
SRC_URI += "file://0017-configs-arm64-imx8m-m-n-p-add-new-harpoon-freertos-c.patch"
SRC_URI += "file://0018-configs-imx8m-m-n-p-add-irqs-and-memory-regions-for-.patch"
SRC_URI += "file://0019-configs-arm64-imx93-add-freertos-and-zephyr-basic-co.patch"
SRC_URI += "file://0020-arm-commun-irqchip-allow-to-trigger-interrupt-handle.patch"
SRC_URI += "file://0021-configs-arm64-imx-8mm-8mp-93-add-freertos-virtio-sup.patch"
SRC_URI += "file://0022-configs-arm64-imx93-add-harpoon-zephyr-and-freertos-.patch"
SRC_URI += "file://0023-configs-arm64-imx8m-m-n-p-add-new-harpoon-zephyr-cel.patch"
SRC_URI += "file://0024-configs-arm64-add-audio-cell-config-for-imx93.patch"
SRC_URI += "file://0025-configs-arm64-imx-8m-93-change-rpmsg-to-normal-memor.patch"
SRC_URI += "file://0026-configs-arm64-imx93-add-avb-freertos-and-zephyr-cell.patch"
SRC_URI += "file://0027-configs-arm64-imx93-add-MX93AUD_HAT-support-on-Harpo.patch"
SRC_URI += "file://0028-configs-arm64-imx8m-m-n-p-zephyr-add-a-core-for-audi.patch"
