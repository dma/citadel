# Auto-Generated by cargo-bitbake 0.3.10
#
inherit cargo

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get sgstatus could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/sgstatus/0.1.0"
SRC_URI += "git://github.com/subgraph/sgstatus;protocol=https"
SRCREV = "a39d5627de38507458fd4f6a5f624ae5faaf797c"
S = "${WORKDIR}/git"
CARGO_SRC_DIR=""
PV_append = ".AUTOINC+a39d5627de"

# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
crate://crates.io/aho-corasick/0.6.4 \
crate://crates.io/atty/0.2.6 \
crate://crates.io/bitflags/1.0.1 \
crate://crates.io/byteorder/1.2.1 \
crate://crates.io/bytes/0.4.6 \
crate://crates.io/cfg-if/0.1.2 \
crate://crates.io/dbus-tokio/0.2.1 \
crate://crates.io/dbus/0.6.1 \
crate://crates.io/env_logger/0.5.4 \
crate://crates.io/error-chain/0.10.0 \
crate://crates.io/fuchsia-zircon-sys/0.3.3 \
crate://crates.io/fuchsia-zircon/0.3.3 \
crate://crates.io/futures/0.1.18 \
crate://crates.io/humantime/1.1.1 \
crate://crates.io/iovec/0.1.2 \
crate://crates.io/kernel32-sys/0.2.2 \
crate://crates.io/lazy_static/1.0.0 \
crate://crates.io/lazycell/0.6.0 \
crate://crates.io/libc/0.2.37 \
crate://crates.io/libdbus-sys/0.1.2 \
crate://crates.io/libpulse-binding/1.0.3 \
crate://crates.io/libpulse-sys/1.0.2 \
crate://crates.io/log/0.3.9 \
crate://crates.io/log/0.4.1 \
crate://crates.io/memchr/2.0.1 \
crate://crates.io/metadeps/1.1.2 \
crate://crates.io/mio/0.6.13 \
crate://crates.io/miow/0.2.1 \
crate://crates.io/net2/0.2.32 \
crate://crates.io/pkg-config/0.3.9 \
crate://crates.io/quick-error/1.2.1 \
crate://crates.io/redox_syscall/0.1.37 \
crate://crates.io/redox_termios/0.1.1 \
crate://crates.io/regex-syntax/0.4.2 \
crate://crates.io/regex/0.2.6 \
crate://crates.io/scoped-tls/0.1.0 \
crate://crates.io/slab/0.3.0 \
crate://crates.io/slab/0.4.0 \
crate://crates.io/termcolor/0.3.5 \
crate://crates.io/termion/1.5.1 \
crate://crates.io/thread_local/0.3.5 \
crate://crates.io/tokio-core/0.1.12 \
crate://crates.io/tokio-io/0.1.5 \
crate://crates.io/tokio-timer/0.1.2 \
crate://crates.io/toml/0.2.1 \
crate://crates.io/unreachable/1.0.0 \
crate://crates.io/utf8-ranges/1.0.0 \
crate://crates.io/void/1.0.2 \
crate://crates.io/winapi-build/0.1.1 \
crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
crate://crates.io/winapi/0.2.8 \
crate://crates.io/winapi/0.3.4 \
crate://crates.io/wincolor/0.1.6 \
crate://crates.io/ws2_32-sys/0.2.1 \
"



LIC_FILES_CHKSUM=" \
"

SUMMARY = "sgstatus"
HOMEPAGE = "https://github.com/subgraph/sgstatus"
LICENSE = "CLOSED"

DEPENDS += " dbus pulseaudio"
do_install() {
	install -d ${D}${libexecdir}

    install -m 755 ${B}/target/${CARGO_TARGET_SUBDIR}/sgstatus ${D}${libexecdir}
}

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include sgstatus-${PV}.inc
include sgstatus.inc
