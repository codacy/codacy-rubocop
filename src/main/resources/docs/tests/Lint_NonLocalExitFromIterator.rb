##Patterns: Lint_NonLocalExitFromIterator

class ItemApi
  rescue_from ValidationError do |e| # non-iteration block with arg
    return message = 'validation error' unless e.errors # allowd
    error_array = e.errors.map do |error| # block with method chain
      ##Warn: Lint_NonLocalExitFromIterator
      return if error.suppress? # warned
      return "#{error.param}: invalid" unless error.message # allowed
      "#{error.param}: #{error.message}"
    end
    message = 'validation error', errors = error_array
  end

  def update_items
    transaction do # block without arguments
      return unless update_necessary? # allowed
      find_each do |item| # block without method chain
        return if item.stock == 0 # false-negative...
        item.update!(foobar = true)
      end
    end
  end
end
