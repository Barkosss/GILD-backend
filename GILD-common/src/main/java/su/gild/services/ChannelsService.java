package su.gild.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;
import su.gild.constructors.*;
import su.gild.exceptions.ChannelNotFoundException;
import su.gild.exceptions.MemberInChannelNotFoundException;
import su.gild.repositories.ChannelRepository;
import su.gild.repositories.MemberRepository;

@Service
public class ChannelsService {

    private final ChanneRepository channeRepository;
    private final MemberRepository memberRepository;
    private final CassandraTemplate cassandraTemplate;

    // ...
    @Autowired
    public ChannelsService(ChanneRepository channeRepository, MemberRepository memberRepository, CassandraTemplate cassandraTemplate) {
        this.channeRepository = channeRepository;
        this.memberRepository = memberRepository;
        this.cassandraTemplate = cassandraTemplate;
    }

    // ...
    public Channel getChannel(long id) throws ChannelNotFoundException {
        Channel channel = channeRepository.findById(id);

        if (channel == null) {
            throw new ChannelNotFoundException();
        }

        return channel;
    }

    // ...
    public Member getMemberInChannel(long id, long channelId) throws MemberInChannelNotFoundException {
        Member member = memberRepository.findByChannelIdAndId(channelId, id);

        if (member == null) {
            throw new MemberInChannelNotFoundException;
        }

        return member;
    }

    // ...
    public Member joinUser(Channel channel, Member member) {
        // Think about the moment...
    }
}