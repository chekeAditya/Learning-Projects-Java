package com.example.loadgithubprofile.ModelClass;

import com.google.gson.annotations.SerializedName;

public class ResponseModelItem{

    @SerializedName("stargazers_count")
    private Integer stargazersCount;

    @SerializedName("pushed_at")
    private String pushedAt;

    @SerializedName("subscription_url")
    private String subscriptionUrl;

    @SerializedName("language")
    private Object language;

    @SerializedName("branches_url")
    private String branchesUrl;

    @SerializedName("issue_comment_url")
    private String issueCommentUrl;

    @SerializedName("labels_url")
    private String labelsUrl;

    @SerializedName("subscribers_url")
    private String subscribersUrl;

    @SerializedName("releases_url")
    private String releasesUrl;

    @SerializedName("svn_url")
    private String svnUrl;

    @SerializedName("id")
    private Integer id;

    @SerializedName("forks")
    private Integer forks;

    @SerializedName("archive_url")
    private String archiveUrl;

    @SerializedName("git_refs_url")
    private String gitRefsUrl;

    @SerializedName("forks_url")
    private String forksUrl;

    @SerializedName("statuses_url")
    private String statusesUrl;

    @SerializedName("ssh_url")
    private String sshUrl;

    @SerializedName("license")
    private Object license;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("size")
    private Integer size;

    @SerializedName("languages_url")
    private String languagesUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("collaborators_url")
    private String collaboratorsUrl;

    @SerializedName("clone_url")
    private String cloneUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("pulls_url")
    private String pullsUrl;

    @SerializedName("default_branch")
    private String defaultBranch;

    @SerializedName("hooks_url")
    private String hooksUrl;

    @SerializedName("trees_url")
    private String treesUrl;

    @SerializedName("tags_url")
    private String tagsUrl;

    @SerializedName("private")
    private Boolean jsonMemberPrivate;

    @SerializedName("contributors_url")
    private String contributorsUrl;

    @SerializedName("has_downloads")
    private Boolean hasDownloads;

    @SerializedName("notifications_url")
    private String notificationsUrl;

    @SerializedName("open_issues_count")
    private Integer openIssuesCount;

    @SerializedName("description")
    private Object description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("watchers")
    private Integer watchers;

    @SerializedName("keys_url")
    private String keysUrl;

    @SerializedName("deployments_url")
    private String deploymentsUrl;

    @SerializedName("has_projects")
    private Boolean hasProjects;

    @SerializedName("archived")
    private Boolean archived;

    @SerializedName("has_wiki")
    private Boolean hasWiki;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("comments_url")
    private String commentsUrl;

    @SerializedName("stargazers_url")
    private String stargazersUrl;

    @SerializedName("disabled")
    private Boolean disabled;

    @SerializedName("git_url")
    private String gitUrl;

    @SerializedName("has_pages")
    private Boolean hasPages;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("commits_url")
    private String commitsUrl;

    @SerializedName("compare_url")
    private String compareUrl;

    @SerializedName("git_commits_url")
    private String gitCommitsUrl;

    @SerializedName("blobs_url")
    private String blobsUrl;

    @SerializedName("git_tags_url")
    private String gitTagsUrl;

    @SerializedName("merges_url")
    private String mergesUrl;

    @SerializedName("downloads_url")
    private String downloadsUrl;

    @SerializedName("has_issues")
    private Boolean hasIssues;

    @SerializedName("url")
    private String url;

    @SerializedName("contents_url")
    private String contentsUrl;

    @SerializedName("mirror_url")
    private Object mirrorUrl;

    @SerializedName("milestones_url")
    private String milestonesUrl;

    @SerializedName("teams_url")
    private String teamsUrl;

    @SerializedName("fork")
    private Boolean fork;

    @SerializedName("issues_url")
    private String issuesUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("issue_events_url")
    private String issueEventsUrl;

    @SerializedName("assignees_url")
    private String assigneesUrl;

    @SerializedName("open_issues")
    private Integer openIssues;

    @SerializedName("watchers_count")
    private Integer watchersCount;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("homepage")
    private Object homepage;

    @SerializedName("forks_count")
    private Integer forksCount;

    public Integer getStargazersCount(){
        return stargazersCount;
    }

    public String getPushedAt(){
        return pushedAt;
    }

    public String getSubscriptionUrl(){
        return subscriptionUrl;
    }

    public Object getLanguage(){
        return language;
    }

    public String getBranchesUrl(){
        return branchesUrl;
    }

    public String getIssueCommentUrl(){
        return issueCommentUrl;
    }

    public String getLabelsUrl(){
        return labelsUrl;
    }

    public String getSubscribersUrl(){
        return subscribersUrl;
    }

    public String getReleasesUrl(){
        return releasesUrl;
    }

    public String getSvnUrl(){
        return svnUrl;
    }

    public Integer getId(){
        return id;
    }

    public Integer getForks(){
        return forks;
    }

    public String getArchiveUrl(){
        return archiveUrl;
    }

    public String getGitRefsUrl(){
        return gitRefsUrl;
    }

    public String getForksUrl(){
        return forksUrl;
    }

    public String getStatusesUrl(){
        return statusesUrl;
    }

    public String getSshUrl(){
        return sshUrl;
    }

    public Object getLicense(){
        return license;
    }

    public String getFullName(){
        return fullName;
    }

    public Integer getSize(){
        return size;
    }

    public String getLanguagesUrl(){
        return languagesUrl;
    }

    public String getHtmlUrl(){
        return htmlUrl;
    }

    public String getCollaboratorsUrl(){
        return collaboratorsUrl;
    }

    public String getCloneUrl(){
        return cloneUrl;
    }

    public String getName(){
        return name;
    }

    public String getPullsUrl(){
        return pullsUrl;
    }

    public String getDefaultBranch(){
        return defaultBranch;
    }

    public String getHooksUrl(){
        return hooksUrl;
    }

    public String getTreesUrl(){
        return treesUrl;
    }

    public String getTagsUrl(){
        return tagsUrl;
    }

    public boolean isJsonMemberPrivate(){
        return jsonMemberPrivate;
    }

    public String getContributorsUrl(){
        return contributorsUrl;
    }

    public boolean isHasDownloads(){
        return hasDownloads;
    }

    public String getNotificationsUrl(){
        return notificationsUrl;
    }

    public Integer getOpenIssuesCount(){
        return openIssuesCount;
    }

    public Object getDescription(){
        return description;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public Integer getWatchers(){
        return watchers;
    }

    public String getKeysUrl(){
        return keysUrl;
    }

    public String getDeploymentsUrl(){
        return deploymentsUrl;
    }

    public boolean isHasProjects(){
        return hasProjects;
    }

    public boolean isArchived(){
        return archived;
    }

    public boolean isHasWiki(){
        return hasWiki;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getCommentsUrl(){
        return commentsUrl;
    }

    public String getStargazersUrl(){
        return stargazersUrl;
    }

    public boolean isDisabled(){
        return disabled;
    }

    public String getGitUrl(){
        return gitUrl;
    }

    public boolean isHasPages(){
        return hasPages;
    }

    public Owner getOwner(){
        return owner;
    }

    public String getCommitsUrl(){
        return commitsUrl;
    }

    public String getCompareUrl(){
        return compareUrl;
    }

    public String getGitCommitsUrl(){
        return gitCommitsUrl;
    }

    public String getBlobsUrl(){
        return blobsUrl;
    }

    public String getGitTagsUrl(){
        return gitTagsUrl;
    }

    public String getMergesUrl(){
        return mergesUrl;
    }

    public String getDownloadsUrl(){
        return downloadsUrl;
    }

    public boolean isHasIssues(){
        return hasIssues;
    }

    public String getUrl(){
        return url;
    }

    public String getContentsUrl(){
        return contentsUrl;
    }

    public Object getMirrorUrl(){
        return mirrorUrl;
    }

    public String getMilestonesUrl(){
        return milestonesUrl;
    }

    public String getTeamsUrl(){
        return teamsUrl;
    }

    public boolean isFork(){
        return fork;
    }

    public String getIssuesUrl(){
        return issuesUrl;
    }

    public String getEventsUrl(){
        return eventsUrl;
    }

    public String getIssueEventsUrl(){
        return issueEventsUrl;
    }

    public String getAssigneesUrl(){
        return assigneesUrl;
    }

    public Integer getOpenIssues(){
        return openIssues;
    }

    public Integer getWatchersCount(){
        return watchersCount;
    }

    public String getNodeId(){
        return nodeId;
    }

    public Object getHomepage(){
        return homepage;
    }

    public Integer getForksCount(){
        return forksCount;
    }
}