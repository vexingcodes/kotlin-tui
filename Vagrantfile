$script = <<-SCRIPT
# Install required Debian packages.
apt-get update
apt-get install --yes ncurses-dev openjdk-8-jdk-headless

# Get the Kotlin/Native toolchain.
cd /tmp
wget -q https://github.com/JetBrains/kotlin/releases/download/v1.3.30/kotlin-native-linux-1.3.30.tar.gz
tar -xf kotlin-native-linux-1.3.30.tar.gz
export PATH="${PATH}:/tmp/kotlin-native-linux-1.3.30/bin"

# Built the Kotlin/Native application.
cd /vagrant
cinterop -def ncurses.def -o ncurses
kotlinc-native -l ncurses tui.kt -o tui
mv tui.kexe /usr/local/bin/

# Stop getty from running on tty1 and ttyS0.
systemctl disable getty@tty1
systemctl stop getty@tty1
systemctl disable serial-getty@ttyS0
systemctl stop serial-getty@ttyS0

# Configure systemd to start the TUI on boot on tty1 and ttyS0.
cp tui@.service /etc/systemd/system
systemctl enable tui@tty1
systemctl start tui@tty1
systemctl enable tui@ttyS0
systemctl start tui@ttyS0
SCRIPT

Vagrant.configure("2") do |config|
  config.vm.box = "debian/stretch64"
  config.vm.synced_folder ".", "/vagrant", type: "rsync"
  config.vm.provision "shell", inline: $script, privileged: true
end
