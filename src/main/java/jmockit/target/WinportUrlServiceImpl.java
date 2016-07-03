package jmockit.target;

/**
 * Created by cengxianbing on 2015/11/10.
 */
public class WinportUrlServiceImpl extends WinportBaseService implements WinportUrlService
{
    @Override
    public boolean hasWinport(String memberId)
    {
        return true;
    }

    @Override
    public String getWinportUrlThrowException(String memberId)
    {
        throw  new RuntimeException();
    }
}
