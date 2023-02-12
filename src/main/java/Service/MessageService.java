package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    MessageDAO messageDAO;

    public MessageService()
    {
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO)
    {
        this.messageDAO = messageDAO;
    }

    //logic under here:
    public List<Message> getAllMessages()
    {
        return messageDAO.getAllMessages();
    }

    // public Message addMessageInfo(Message message)
    // {
    //     return messageDAO.addMessage(message);
    // }

    public Message insertMessageInfo(Message message)
    {
        return messageDAO.insertMessage(message);
    }

    //??
    public Message getMessageAfterPosting(int id)
    {
        return messageDAO.getMessage(id);
    }

    //Delete works, but when the API calls the message it's not deleted
    public Message deleteMessage(int id, Message message)
    {
        //Message test = messageDAO.getMessage(id);
        // test.setMessage_id(message.getMessage_id());
        message.setMessage_id(id);
        messageDAO.deletedMessage(id, message);
        //messageDAO.deletedMessage(id, message);
        return message;
    }

    //Update works, but gets 500 error when called for a non existing message
    public Message patchMessageText(int id, Message message)
    {
        message.setMessage_text(message.getMessage_text());
        message.setMessage_id(id);
        message.setPosted_by(id);
        message.setTime_posted_epoch(messageDAO.getMessage(id).getTime_posted_epoch());
        messageDAO.patchMessage(id, message);
        return message;
    }

    public List<Message> getAllMessagesByAccountId()
    {
        return messageDAO.getAllMessagesByAccountId();
    }

}
