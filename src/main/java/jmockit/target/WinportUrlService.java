package jmockit.target;

/**
 * Created by cengxianbing on 2015/11/10.
 */
public interface WinportUrlService
{

    boolean hasWinport(String memberId);

    String getWinportUrlThrowException(String memberId);
}
