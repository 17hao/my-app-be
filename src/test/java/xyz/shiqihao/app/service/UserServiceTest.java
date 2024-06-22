package xyz.shiqihao.app.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import xyz.shiqihao.app.dao.UserDao;
import xyz.shiqihao.app.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserDao dao;

    @InjectMocks
    private UserService service;

    @Test
    public void testFindByUserId() {
        Mockito.when(dao.findById(1)).thenReturn(new User(1));
        Assert.assertEquals(1, service.findById(1).getId());
    }
}
