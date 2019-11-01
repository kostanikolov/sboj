package app.web.beans;

import app.domain.entities.SectorType;
import app.domain.models.binding.JobCreateBindingModel;
import app.domain.models.service.JobApplicationServiceModel;
import app.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobCreateBean extends BaseBean {

	private JobCreateBindingModel jobCreateBindingModel;
	private JobApplicationService jobApplicationService;
	private ModelMapper modelMapper;

	public JobCreateBean() {
	}

	@PostConstruct
	public void init() {
		this.jobCreateBindingModel = new JobCreateBindingModel();
	}

	@Inject
	public JobCreateBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
		this.jobApplicationService = jobApplicationService;
		this.modelMapper = modelMapper;
	}

	public void create() {
		JobApplicationServiceModel model = this.modelMapper.map(this.jobCreateBindingModel, JobApplicationServiceModel.class);
		SectorType sectorType = null;

		try	{
			sectorType = SectorType.valueOf(this.jobCreateBindingModel.getSectorType().toUpperCase());
		} catch (Exception ex) {
			this.redirect("/add-job");
		}

		model.setSectorType(sectorType);
		this.jobApplicationService.save(model);
		this.redirect("/home");
	}

	public JobCreateBindingModel getJobCreateBindingModel() {
		return this.jobCreateBindingModel;
	}

	public void setJobCreateBindingModel(JobCreateBindingModel jobCreateBindingModel) {
		this.jobCreateBindingModel = jobCreateBindingModel;
	}
}
