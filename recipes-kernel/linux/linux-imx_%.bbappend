FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-arm64-dts-imx8mm-imx8mn-add-dts-for-lk.patch"
SRC_URI += "file://0002-arm64-dts-imx8mm-evk-lk-imx8mn-ddr4-evk-lk-add-rpmsg.patch"
SRC_URI += "file://0003-arm64-dts-imx8mn-lpddr4-add-dts-for-lk.patch"
SRC_URI += "file://0004-configs-Disable-ivshm-uio-driver.patch"
SRC_URI += "file://0005-Revert-of-fdt-Make-sure-no-map-does-not-remove-alrea.patch"
SRC_URI += "file://0006-Revert-fdt-Properly-handle-no-map-field-in-the-memor.patch"
