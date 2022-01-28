package com.redhat.eagleeye.records;

public class IpProfileAccumulator {
    private long requestCount;
    private long totalBytes;
    long fileCount;

    public IpProfileAccumulator() {
    }

    public IpProfileAccumulator(Long requestCount, Long totalBytes,Long fileCount) {
        this.totalBytes = totalBytes;
        this.requestCount = requestCount;
        this.fileCount = fileCount;
    }


    public long getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(final long totalBytes) {
        this.totalBytes = totalBytes;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(final long requestCount) {
        this.requestCount = requestCount;
    }

    public long getFileCount() {
        return fileCount;
    }

    public void setFileCount(final long fileCount) {
        this.fileCount = fileCount;
    }
}
