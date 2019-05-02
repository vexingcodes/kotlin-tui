# Kotlin TUI

This is a barebones Kotlin/Native Linux application that uses C interoperability
to link against the native ncurses library and display a simple full-screen
message. A systemd service unit template is provided that can run the
application against any tty on the system. A simple Vagrantfile is provided that
will spin up Debian Stretch, compile the application, and run it on tty1 and
ttyS0.

# Usage

Install [vagrant](https://www.vagrantup.com) and a suitable provider
(VirtualBox, libvirt, etc.). Then simply run `vagrant up`. Once the provisioning
script has completed you should see `Press any key to exit!` both on the video
terminal of the virtual machine and the serial console.
