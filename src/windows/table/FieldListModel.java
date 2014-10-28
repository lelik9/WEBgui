package windows.table;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.event.ListDataListener;
import nextapp.echo.app.list.AbstractListModel;
import nextapp.echo.app.list.ListModel;

public class FieldListModel extends AbstractListModel 
{
	private List<String> list;
	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}

	@Override
	public Object get(int index)
	{
		// TODO Auto-generated method stub
		
		return list.get(index);
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return list.size();
	}
	
	protected void fireContentsChanged(int index0,
            int index1)
            {

            }

	
}
