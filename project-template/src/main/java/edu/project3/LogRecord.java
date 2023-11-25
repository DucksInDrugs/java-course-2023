package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRecord {
    private static final Pattern LOG_REGEX = Pattern.compile(
        "^(?<remoteAddr>[^ ]*) - (?<remoteUser>[^ ]*) \\[(?<timeLocal>[^\\]]*)\\] \"(?<request>[^\"]+)\" (?<status>[^ ]*) (?<bodyBytesSent>[^ ]*) \"(?<httpReferer>[^\\\"]*)\" \"(?<httpUserAgent>[^\\\"]*)\"$"
    );
    private static final String DATE_PATTERN = "dd/MMM/yyyy:HH:mm:ss Z";

    private String remoteAddr;
    private String remoteUser;
    private OffsetDateTime timeLocal;
    private Request request;
    private int status;
    private long bodyBytesSent;
    private String httpReferer;
    private String httpUserAgent;

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public OffsetDateTime getTimeLocal() {
        return timeLocal;
    }

    public Request getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public long getBodyBytesSent() {
        return bodyBytesSent;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public String getHttpUserAgent() {
        return httpUserAgent;
    }

    public LogRecord(
        String remoteAddr,
        String remoteUser,
        OffsetDateTime timeLocal,
        Request request,
        int status,
        int bodyBytesSent,
        String httpReferer,
        String httpUserAgent
    ) {
        this.remoteAddr = remoteAddr;
        this.remoteUser = remoteUser;
        this.timeLocal = timeLocal;
        this.request = request;
        this.status = status;
        this.bodyBytesSent = bodyBytesSent;
        this.httpReferer = httpReferer;
        this.httpUserAgent = httpUserAgent;
    }

    public static LogRecord parse(String log) {
        Matcher matcher = LOG_REGEX.matcher(log);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return new LogRecord(
            matcher.group("remoteAddr"),
            matcher.group("remoteUser"),
            OffsetDateTime.parse(matcher.group("timeLocal"), dateTimeFormatter),
            Request.parse(matcher.group("request")),
            Integer.parseInt(matcher.group("status")),
            Integer.parseInt(matcher.group("bodyBytesSent")),
            matcher.group("httpReferer"),
            matcher.group("httpUserAgent"));
    }
}
