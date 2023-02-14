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

    public List<Message> getAllMessages()
    {
        return messageDAO.getAllMessages();
    }

    public Message insertMessageInfo(Message message)
    {
        return messageDAO.insertMessage(message);
    }

    public Message getMessageAfterPosting(int id)
    {
        return messageDAO.getMessageById(id);
    }

    public List<Message> getAllMessagesByAccountId(int id)
    {
        return messageDAO.getAllMessagesByAccountId(id);
    }

    public Message getMessage(int id)
    {
        Message message = messageDAO.getMessageById(id);
        return message;
    }

    public Message deleteMessage(int id)
    {
        if(getMessage(id) == null)
        {
            return null;
        }

        if(getMessage(id) != null)
        {
            return messageDAO.getMessage(id); 
        }
        return null;
    }

    public Message getMessageById(int message_id) {
        Message message = messageDAO.getMessageById(message_id);
        if (message.getMessage_text().isEmpty()) {
            return null;
        } else {
            return message;
        }
    }

    public Message updateMessages(int id, Message message)
    {
        if(getMessageById(id) != null && message.message_text != "" && message.message_text.length() <= 255)
        {
            return messageDAO.updateMessage(id, message); 
        }
        return null;
    }

}
