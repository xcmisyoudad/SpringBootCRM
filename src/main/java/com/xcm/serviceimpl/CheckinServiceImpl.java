package com.xcm.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xcm.entity.CheckIn;
import com.xcm.entity.PageNation;
import com.xcm.entity.Users;
import com.xcm.mapper.CheckinMapper;
import com.xcm.service.CheckinService;

@Service
public class CheckinServiceImpl implements CheckinService {
	@Autowired
	private CheckinMapper checkinMapper;

	@Override
	public PageNation getZiXunShiList(PageNation pageNation) {
		// TODO Auto-generated method stub
		pageNation.setPage((pageNation.getPage() - 1) * pageNation.getLimit());
		pageNation.setLimit(pageNation.getLimit());
		pageNation.setCode(0);
		pageNation.setMsg("危险");
		pageNation.setData(checkinMapper.getZiXunShiList(pageNation));
		pageNation.setCount(checkinMapper.getZiXunShiCount(pageNation));
		return pageNation;
	}

	@Override
	public List<CheckIn> getChekinListById(int users_Id) {
		// TODO Auto-generated method stub
		return checkinMapper.getChekinListById(users_Id);
	}

	@Override
	public PageNation getChekinListByIdPage(PageNation pageNation) {
		// TODO Auto-generated method stub
		pageNation.setPage((pageNation.getPage() - 1) * pageNation.getLimit());
		pageNation.setLimit(pageNation.getLimit());
		pageNation.setCode(0);
		pageNation.setMsg("危险");
		pageNation.setData(checkinMapper.getChekinListByIdPage(pageNation));
		pageNation.setCount(checkinMapper.getChekinListByIdCount(pageNation));
		return pageNation;
	}

	@Override
	public Boolean updateOneCheckIn(Users users) {
		// TODO Auto-generated method stub
		CheckIn checkIn = checkinMapper.selectLastCheckInByUsers_Id(users.getUsers_Id());
		users.setUsers_CheckInStatus(3);
		int num = checkinMapper.updateOneCheckIn(users);
		Date date = new Date();
		// 设置要获取到什么样的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取String类型的时间
		String createdate = sdf.format(date);
		checkIn.setCheckIn_EndTime(createdate);
		checkIn.setCheckIn_Status(3);
		int num2 = checkinMapper.updateCheckInStatus(checkIn);
		if (num > 0 && num2 > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updateCheckInByUsers(Users users) throws ParseException {
		// TODO Auto-generated method stub
		// 先根据用户id查询签到记录,如果签到记录是未签到,就执行签到
		CheckIn checkIn = checkinMapper.selectLastCheckInByUsers_Id(users.getUsers_Id());
		if (checkIn.getCheckIn_Status() == 1) {
			users.setUsers_CheckInStatus(2);
			int num = checkinMapper.updateOneCheckIn(users);
			// 上班时间

			Date date = new Date();
			// 设置要获取到什么样的时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
			// 获取String类型的时间
			String createdate = sdf.format(date);
			// 默认上班时间为八点
			String startTime = "8:00";
			// 根据当前时间的时和分判断谁大谁小
			String endTime = sdf2.format(date);
			Date date1 = sdf2.parse(startTime);
			Date date2 = sdf2.parse(endTime);
			int compareTo = date1.compareTo(date2);
			// 为-1代表签到的时候当前时间比规定时间大,那就是迟到了
			if (compareTo == -1) {
				checkIn.setCheckIn_Late(0);
			}
			// 否则就是未迟到
			else {
				checkIn.setCheckIn_Late(1);
			}
			checkIn.setCheckIn_Time(createdate);
			checkIn.setCheckIn_Status(2);
			int num2 = checkinMapper.updateCheckInStatus(checkIn);
			if (num > 0 && num2 > 0) {
				return 1;// 1代表签到成功
			} else {
				return 2;// 代表有问题,让他继续尝试
			}
		} 
		else {
			return 3;// 已经签到过了,别让他重复签到
		}

	}

}
