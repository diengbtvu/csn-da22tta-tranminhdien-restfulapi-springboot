#!/bin/bash

# Script cài đặt Docker trên Ubuntu Server
echo "🐳 Cài đặt Docker và Docker Compose..."

# Cập nhật hệ thống
sudo apt update && sudo apt upgrade -y

# Cài đặt các package cần thiết
sudo apt install -y apt-transport-https ca-certificates curl software-properties-common

# Thêm Docker GPG key
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

# Thêm Docker repository
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

# Cập nhật package list
sudo apt update

# Cài đặt Docker
sudo apt install -y docker-ce docker-ce-cli containerd.io

# Thêm user hiện tại vào group docker
sudo usermod -aG docker $USER

# Cài đặt Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/download/v2.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# Khởi động Docker service
sudo systemctl start docker
sudo systemctl enable docker

echo "✅ Docker đã được cài đặt thành công!"
echo "📝 Vui lòng logout và login lại để sử dụng Docker không cần sudo"

# Kiểm tra version
docker --version
docker-compose --version
