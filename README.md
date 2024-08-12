# SS STORAGE

## Motivation

I had a need for free file storage for my pet projects, but software services like amazon s3 or backblaze provide services only in a paid format. This was the motivation to create an api service for storing images, which in the future can be reused in the form of a docker container

## Installation

**1. Download repository**
```bash
git clone https://github.com/p4sttt/ss-storage.git
```

**2. Build docker image** 
```bash
docker build -t ss-storage .
```

**3. Run docker container**
```bash
docker -d -p 8080:8080 ss-storage
```

## Usage

### Api endpoints

---

#### POST ``/api/image``
Create a file in folder $HOME/ss-storage/upload/image

**Success response**
```json
{
  "code": 200,
  "timestamp": "24-08-12 14:22:09",
  "message": "Image was successfully uploaded",
  "data": {
    "image_id": "6dcdd848-ba37-49e7-8b69-7d0fafb0f270"
  }
}
```

---

#### GET ``/api/image/{image_id}``
Return an array of bytes

---

### For insomnia users

The ``/insomnia`` directory contains .json files with environment variables and a collection of queries that can be imported into Insomnia