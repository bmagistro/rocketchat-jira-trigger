package se.gustavkarlsson.rocketchat.jira_trigger.messages.fields;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.User;

public class AssigneeFieldExtractor extends AbstractFieldExtractor {

	private final boolean useRealName;

	public AssigneeFieldExtractor(boolean useRealName) {
		this.useRealName = useRealName;
	}

	@Override
	protected String getTitle() {
		return "Assigned To";
	}

	@Override
	protected String getValue(Issue issue) {
		User assignee = issue.getAssignee();
		if (assignee == null) {
			return "-";
		}
		return useRealName ? assignee.getDisplayName() : assignee.getName();
	}

	@Override
	protected boolean isShortValue() {
		return true;
	}
}