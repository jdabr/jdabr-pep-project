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
    // public Message deleteMessage(int id, Message message)
    // {
    //     //Message test = messageDAO.getMessage(id);
    //     // test.setMessage_id(message.getMessage_id());
    //     message.setMessage_id(id);
    //     messageDAO.deletedMessage(id, message);
    //     //messageDAO.deletedMessage(id, message);
    //     return message;
    // }


    public List<Message> getAllMessagesByAccountId()
    {
        return messageDAO.getAllMessagesByAccountId();
    }

    //TESTING
    public Message getMessageById(int message_id) {
        Message message = messageDAO.getMessageById(message_id);
        if (message.getMessage_text().isEmpty()) {
            return null;
        } else {
            return message;
        }
    }

    public Message deleteMessage(int id)
    {
        if(getMessageById(id) != null)
        {
            return messageDAO.getMessage(id); 
        }
        return null;
    }

    public Message updateMessages(int message_id, Message message)
    {
        if(getMessageById(message_id) != null && message.message_text != "" && message.message_text.length() <= 255)
        {
            return messageDAO.updateMessage(message_id, message); 
        }
        return null;
    }

}
