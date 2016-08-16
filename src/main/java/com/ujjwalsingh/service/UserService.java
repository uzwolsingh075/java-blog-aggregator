package com.ujjwalsingh.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujjwalsingh.entity.Users;
import com.ujjwalsingh.repositories.UserRepository;
import com.ujjwalsingh.rss.ObjectFactory;
import com.ujjwalsingh.rss.TRss;
import com.ujjwalsingh.rss.TRssChannel;
import com.ujjwalsingh.rss.TRssItem;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public ArrayList<Users> allUsers() {
		
		 Users User = new Users(); Users User1 = new Users();
		 User.setName("Ujjwal"); User.setAddress("California");
		 userRepository.save(User); User1.setName("admin");
		 User1.setAddress("Nepal"); userRepository.save(User1);
		 

		ArrayList<Users> users = (ArrayList<Users>) userRepository.findAll();
		return users;
	}

	public Users getUserById(int id) {
		Users user = userRepository.findOne(id);
		return user;
	}

	@PreAuthorize("#user.name == authentication.name")
	public void testPreAuthorize(@P("user") Users user) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

	@Transactional
	public void saveUser(Users user) {
		userRepository.save(user);
	}

	public boolean findUserExist(String username) {
		if (userRepository.findByName(username) == null) {
			return true;
		}
		return false;
	}

	public void getItems(Source source) {
		try {
			JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<TRss> element = unmarshaller.unmarshal(source, TRss.class);
			TRss rss = element.getValue();
			List<TRssChannel> channels = rss.getChannel();
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				for (TRssItem item : items) {
					System.out.println(item.getTitle());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
