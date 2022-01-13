# Real-time Edge Harpoon Software Manifest README

## Install the `repo` utility (only need to do this once)

To get the Real-time Edge environment you need to have `repo` installed.

This 'repo' is used to download manifests for Real-time Edge releases.

```
$ mkdir ~/bin
$ curl https://storage.googleapis.com/git-repo-downloads/repo  > ~/bin/repo
$ chmod a+x ~/bin/repo
$ export PATH=${PATH}:~/bin
```

## Download a specific release of Real-time Edge Environment

The corresponding branch should be used when downloading a specific release.

Please refer to detailed README under the release branch.

### Examples

To download the Real-time Edge 2.1.1 release

```
$ mkdir yocto-real-time-edge
$ cd yocto-real-time-edge
$ repo init -u https://github.com/real-time-edge-sw/yocto-real-time-edge.git -b real-time-edge-hardknott -m real-time-edge-2.1.1.xml
$ repo sync
```

## Setup build project

```
$ MACHINE=<Machine> DISTRO=<Distro> source ./harpoon-real-time-edge-setup-env.sh -b bld-<Name>
```

Machine:
- imx8mm-lpddr4-evk
- imx8mp-lpddr4-evk

Distro:
- nxp-real-time-edge – The regular image including Real-time Networking, Real-time System, and Industrial packages.

Name:
- identical string for the build project

### Examples

```
$ DISTRO=nxp-real-time-edge MACHINE=imx8mp-lpddr4-evk source harpoon-real-time-edge-setup-env.sh -b build-imx8mpevk-real-time-edge
```

## Build an image

```
$ bitbake <Image>
```

Image:
- nxp-image-real-time-edge: demo image for all supported machines.

### Examples

```
$ bitbake nxp-image-real-time-edge
```
