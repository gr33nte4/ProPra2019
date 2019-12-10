package propra.grpproj.quiz.dataholders;

/**
 * 
 * @author Daniel
 *
 */
public class Question
{
	/**
	 * Primary Key
	 */
	private Long questionId;
	
	/**
	 * Foreign key for linking the tables
	 */
	private Long roundId;
	private Long userId;

	public Question(Long questionId, Long roundId, Long userId)
	{
		super();
		this.questionId = questionId;
		this.roundId = roundId;
		this.userId = userId;
	}

	@Override
	public String toString()
	{
		return "Question [questionId=" + questionId + ", roundId=" + roundId + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}

	public Long getQuestionId()
	{
		return questionId;
	}

	public Long getRoundId()
	{
		return roundId;
	}

	public Long getUserId()
	{
		return userId;
	}

}
