import requests
from pytube import YouTube

def download_video(url, path='./'):
    try:
        # Create a YouTube object with the URL
        yt = YouTube(url)
        
        # Get the highest resolution stream available
        stream = yt.streams.get_highest_resolution()
        
        # Download the video to the specified path
        print(f"Downloading: {yt.title}")
        stream.download(output_path=path)
        print("Download completed!")
        
    except Exception as e:
        print(f"An error occurred: {e}")


video_url = input("Enter the YouTube video URL: ")
download_path = input("Enter the download path (leave blank for current directory): ")
download_video(video_url, download_path if download_path else './')
