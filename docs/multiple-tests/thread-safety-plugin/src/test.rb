class FollowupFaxer
  def self.fax(params)
    @params = params
    validate(@params)
    send_fax(@params)
  end
end
