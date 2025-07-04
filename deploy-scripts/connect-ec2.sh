#!/bin/bash

# Script kết nối đến EC2 instance
EC2_IP="3.80.117.9"
PEM_FILE="../dtdm.pem"

echo "🔗 Kết nối đến EC2 instance..."
echo "IP: $EC2_IP"
echo "PEM file: $PEM_FILE"

# Thiết lập quyền cho file .pem
chmod 400 $PEM_FILE

# Kết nối SSH
ssh -i $PEM_FILE ubuntu@$EC2_IP
